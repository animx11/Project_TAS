import { Bands } from './bands'
import { Songs } from './songs'

export class Albums{

	private id: number;
	private albumName: String;
	private band: String;
	private songs: String;
	private lengthOfAlbum: number;
	private averageRateOfAlbum: number;

	constructor(obj?: any){
	
		this.id = (obj && obj.id) || 0;
		this.albumName = (obj && obj.albumName) || '';
		this.band = (obj && obj.band) || '';
		this.songs = (obj && obj.songs) || '';
		this.lengthOfAlbum = (obj && obj.lengthOfAlbum) || 0;
		this.averageRateOfAlbum = (obj && obj.averageRateOfAlbum) || 0;

	}

	getId(): number{
		return this.id;
	}
	setId(id: number){
		this.id = id;
	}
	
	getAlbumName(): String{
		return this.albumName;
	}
	setAlbumName(albumName: String){
		this.albumName = albumName;
	}
	
	getBand(): String{
		return this.band;
	}
	setBand(band: String){
		this.band = band;
	}
	
	getSongs(): String{
		return this.songs;
	}
	setSongs(songs: String){
		this.songs = songs;
	}
	
	getLengthOfAlbum(): number{
		return this.lengthOfAlbum;
	}
	setLengthOfAlbum(lengthOfAlbum: number){
		this.lengthOfAlbum = lengthOfAlbum;
	}

	getAverageRateOfAlbum(): number{
		return this.averageRateOfAlbum;
	}
	setAverageRateOfAlbum(averageRateOfAlbum: number){
		this.averageRateOfAlbum = averageRateOfAlbum;
	}

}