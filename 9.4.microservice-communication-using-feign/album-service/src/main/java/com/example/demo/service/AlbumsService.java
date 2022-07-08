package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.AlbumEntity;

public interface AlbumsService {
	List<AlbumEntity> getAlbums(String userId);
}