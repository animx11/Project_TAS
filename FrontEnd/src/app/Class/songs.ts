import { Bands } from './bands'

export class Songs{

	private id: number;
	private songName: String;
	private yearOfCreation: number;
	private genre: String;
	private lengthOfSong: number;
	private averageRateOfSong: number;
	private albums: String;
	private band: String;


	constructor(obj?: any){
	
		this.id = (obj && obj.id) || 0;
		this.songName = (obj && obj.songName) || '';
		this.yearOfCreation = (obj && obj.yearOfCreation) || 0;
		this.genre = (obj && obj.genre) || '';
		this.lengthOfSong = (obj && obj.lengthOfSong) || 0;
		this.averageRateOfSong = (obj && obj.averageRateOfSong) || 0;
		this.albums = (obj && obj.albums) || '';
		this.band = (obj && obj.band) || '';

	}

	getId(): number{
		return this.id;
	}
	setId(id: number){
		this.id = id;
	}
	
	getSongName(): String{
		return this.songName;
	}
	setSongName(songName: String){
		this.songName = songName;
	}
	
	getYearOfCreation(): number{
		return this.yearOfCreation;
	}
	setYearOfCreation(yearOfCreation: number){
		this.yearOfCreation = yearOfCreation;
	}
	
	getGenre(): String{
		return this.genre;
	}
	setGenre(genre: String){
		this.genre = genre;
	}
	
	getLengthOfSong(): number{
		return this.lengthOfSong;
	}
	setLengthOfSong(lengthOfSong: number){
		this.lengthOfSong = lengthOfSong;
	}

	getAverageRateOfAlbum(): number{
		return this.averageRateOfSong;
	}
	setAverageRateOfAlbum(averageRateOfSong: number){
		this.averageRateOfSong = averageRateOfSong;
	}

	getAlbums(): String{
		return this.albums;
	}
	setAlbums(albums: String){
		this.albums = albums;
	}

	getBand(): String{
		return this.band;
	}
	setBand(band: String){
		this.band = band;
	}


}