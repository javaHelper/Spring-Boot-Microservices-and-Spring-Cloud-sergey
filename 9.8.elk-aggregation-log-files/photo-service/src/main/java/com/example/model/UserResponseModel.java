package com.example.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserResponseModel {
	private String userId;
	private String firstName;
	private String lastName;
	private List<AlbumResponseModel> albums;
}
