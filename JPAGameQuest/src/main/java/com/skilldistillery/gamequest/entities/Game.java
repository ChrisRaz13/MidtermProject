package com.skilldistillery.gamequest.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;

	private String description;

	@Column(name = "release_date")
	private LocalDateTime releaseDate;

	@Column(name = "avatar_url")
	private String avatarUrl;

	@Column(name = "trailer_url")
	private String trailerUrl;

	@Column(name = "user_id")
	private int userId;

	@OneToOne
	@JoinColumn(name = "company_id")
	private Company company;

	@OneToOne
	@JoinColumn(name = "age_rating_id")
	private AgeRating rating;

	@OneToMany(mappedBy = "game")
	private List<GameImage> gameImages;

	@ManyToMany
	@JoinTable(name = "platform_game", joinColumns = @JoinColumn(name = "game_id"), inverseJoinColumns = @JoinColumn(name = "platform_id"))
	private List<Platform> gamePlatforms;

	@ManyToMany
	@JoinTable(name = "genre_game", joinColumns = @JoinColumn(name = "game_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
	private List<Genre> genres;

	@ManyToMany(mappedBy = "userGames")
	private List<User> gameUsers;

	public Game() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDateTime releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public String getTrailerUrl() {
		return trailerUrl;
	}

	public void setTrailerUrl(String trailerUrl) {
		this.trailerUrl = trailerUrl;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public AgeRating getRating() {
		return rating;
	}

	public void setRating(AgeRating rating) {
		this.rating = rating;
	}

	public List<GameImage> getGameImages() {
		return gameImages;
	}

	public void setGameImages(List<GameImage> gameImages) {
		this.gameImages = gameImages;
	}

	public List<Platform> getGamePlatforms() {
		return gamePlatforms;
	}

	public void setGamePlatforms(List<Platform> gamePlatforms) {
		this.gamePlatforms = gamePlatforms;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public List<User> getGameUsers() {
		return gameUsers;
	}

	public void setGameUsers(List<User> gameUsers) {
		this.gameUsers = gameUsers;
	}

	@Override
	public int hashCode() {
		return Objects.hash(avatarUrl, company, description, gameImages, gamePlatforms, gameUsers, genres, id, rating,
				releaseDate, title, trailerUrl, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return Objects.equals(avatarUrl, other.avatarUrl) && Objects.equals(company, other.company)
				&& Objects.equals(description, other.description) && Objects.equals(gameImages, other.gameImages)
				&& Objects.equals(gamePlatforms, other.gamePlatforms) && Objects.equals(gameUsers, other.gameUsers)
				&& Objects.equals(genres, other.genres) && id == other.id && Objects.equals(rating, other.rating)
				&& Objects.equals(releaseDate, other.releaseDate) && Objects.equals(title, other.title)
				&& Objects.equals(trailerUrl, other.trailerUrl) && userId == other.userId;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", title=" + title + ", description=" + description + ", releaseDate=" + releaseDate
				+ ", avatarUrl=" + avatarUrl + ", trailerUrl=" + trailerUrl + ", userId=" + userId + ", company="
				+ company + ", rating=" + rating + ", gameImages=" + gameImages + ", gamePlatforms=" + gamePlatforms
				+ ", genres=" + genres + ", gameUsers=" + gameUsers + "]";
	}

	public void addGenre(Genre genre) {
		if (genres == null) {
			genres = new ArrayList<>();
		}
		if (!genres.contains(genre)) {
			genres.add(genre);
			genre.addGame(this);
		}
	}

	public void removeGenre(Genre genre) {
		if(genres != null && genres.contains(genre)) {
			genres.remove(genre);
			genre.removeGame(this);
		}
	}

	public void addGamePlatform(Platform platform) {
		if(gamePlatforms == null) {
			gamePlatforms = new ArrayList<>();
		}
		if(!gamePlatforms.contains(platform)) {
			gamePlatforms.add(platform);
			platform.addGame(this);		
		}
	}

	public void removeGamePlatform(Platform platform) {
		if(gamePlatforms != null && gamePlatforms.contains(platform)) {
			gamePlatforms.remove(platform);
			platform.removeGame(this);
		}
	}
	
	public  void addGameUser(User user) {
		if(gameUsers == null) {
			gameUsers = new ArrayList<>();
		}
		if(!gameUsers.contains(user)) {
			gameUsers.add(user);
			user.addUserGame(this);
		}
	}
	
	public void removeGameUser(User user) {
		if(gameUsers != null && gameUsers.contains(user)) {
			gameUsers.remove(user);
			user.removeUserGame(this);
		}
	}

}
