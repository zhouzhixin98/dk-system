package org.zzx.dksystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class CommonController
{
	@GetMapping("/{url}")
	public String url(@PathVariable String url)
	{
		return url;
	}
}
