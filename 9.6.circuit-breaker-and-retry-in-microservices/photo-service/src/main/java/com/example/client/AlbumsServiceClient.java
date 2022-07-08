package com.example.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.model.AlbumResponseModel;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@FeignClient(name = "albums-ws")
public interface AlbumsServiceClient {

	@GetMapping("/users/{id}/albums")
	@Retry(name = "albums-ws")
	@CircuitBreaker(name = "albums-ws", fallbackMethod = "getAlbumsFallback")
	public List<AlbumResponseModel> getAlbums(@PathVariable String id);
	
	
	default List<AlbumResponseModel> getAlbumsFallback(String id, Throwable throwable){
		System.out.println("Param = "+ id);
		System.out.println("Exception Took Place = "+ throwable.getMessage());
		return new ArrayList<>();
	}
}
