package com.ensim.tp5.controller;

import java.net.InetSocketAddress;
import java.net.Proxy;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.ensim.tp5.model.DarkSky;
import com.ensim.tp5.model.Result;


@Controller
public class MeteoController {
	
	@PostMapping("/meteo")
	public String findMeteo(@RequestBody String adresse, Model model)
	{
		SimpleClientHttpRequestFactory clientHttpReq = new SimpleClientHttpRequestFactory();
		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.univ-lemans.fr", 3128));
		clientHttpReq.setProxy(proxy);
		RestTemplate restTemplate = new RestTemplate(clientHttpReq);
		Result c = restTemplate.getForObject("https://api-adresse.data.gouv.fr/search/?q="+adresse, Result.class);
		double lon = c.getFeatures().get(0).getGeometry().getCoordinates().get(0);
		double lat = c.getFeatures().get(0).getGeometry().getCoordinates().get(1);
		DarkSky s = restTemplate.getForObject("https://api.darksky.net/forecast/35027a4b564ddb80e37e51e4b2d6118a/"+lat+","+lon+"?lang=fr&exclude=hourly&exclude=daily&exclude=flags&units=si", DarkSky.class);
		model.addAttribute("meteo",s.getCurrently().getTemperature());
		model.addAttribute("summary", s.getCurrently().getSummary());
		model.addAttribute("adresse",c.getFeatures().get(0).getProperties().getContext());
		model.addAttribute("ville",c.getFeatures().get(0).getProperties().getCity());
		return "Meteo";
	}
}
