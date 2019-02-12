import { Component, OnInit } from '@angular/core';
import { Songs } from '../../../Class/songs';
import { SongsService } from '../../../Services/songs.service';
import { HttpClient, HttpEvent, HttpResponse, HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-find-by-song-name',
  templateUrl: './find-by-song-name.component.html',
  styleUrls: ['./find-by-song-name.component.css']
})
export class FindBySongNameComponent implements OnInit {

	searched: boolean = false;
	searchedAll: boolean = false;
	edit: boolean = false;

	songName: String;
	songSearched: Songs = new Songs;
	songAll: Songs[];

	editSongName: String;
	yearOfCreation: number;
	genre: String;
	lengthOfSong: number;
	albumsName: String;
	bandName: String;
	

  constructor(private songsService: SongsService) { }

  ngOnInit() {
	  
	this.songName = '';
	
	this.editSongName = '';
	this.yearOfCreation = 0;
	this.genre = '';
	this.lengthOfSong= 0;
	this.albumsName= '';
	this.bandName= '';
	
	this.songSearched = new Songs();
	  
  }
  
  findBySongName(){
	  
	  this.songSearched = new Songs();
	  if(this.songName == ''){
		  window.alert("Nie podano nazwy do wyszukania");
	  }
	  
	  else{
		  
		  this.songsService.findBySongName(this.songName).subscribe(res => {
				console.log(res);
				
				res.map(el => {
				
						this.songSearched = new Songs(el);
						this.editSongName = this.songSearched.getSongName();
						this.yearOfCreation = this.songSearched.getYearOfCreation();
						this.genre = this.songSearched.getGenre();
						this.lengthOfSong = this.songSearched.getLengthOfSong();
						this.albumsName = this.songSearched.getAlbums();
						this.bandName = this.songSearched.getBand();

					});
					 
		  });
		  this.songName = '';
		  this.searched = true;

	  }
	  
  }
  
  findAll(){
	  
	  		
		this.songsService.findAll().subscribe(
			res => {
			this.songAll = res.map(el => new Songs(el));
			console.log(res);
		},
		err => {
			window.alert("Nie udało połączyć się z serwerem");
		}	
	  );
	  
  }
  
  deleteSong(){
	  
	  	this.songsService.deleteSong(this.songSearched.getId()).subscribe(
		res => {
			console.log(res);
			window.alert("Usunięto album z bazy");
		},
		err => {	
				console.log(err);
				window.alert("Wystąpił błąd podczas usuwania albumu, sprawdź czy album istnieje lub połączenie z serwerem");	
			}
		
		);
	  this.songSearched = new Songs;
	  this.searched = false;
	  
  }
  
  editSong(){
	  


		if(this.editSongName == '' || this.yearOfCreation <= 1900 || this.yearOfCreation >= 2019 || this.genre == '' || this.albumsName == '' || this.bandName == ''){
			window.alert("Dane są niekompletne i/lub nieprawidłowe");
		}
		else{
			this.songSearched.setSongName(this.editSongName);
			this.songSearched.setYearOfCreation(this.yearOfCreation);
			this.songSearched.setGenre(this.genre);
			this.songSearched.setLengthOfSong(this.lengthOfSong);
			this.songSearched.setAlbums(this.albumsName);
			this.songSearched.setBand(this.bandName);
			
			this.songsService.editSong(this.songSearched).subscribe(res => {
				console.log(res);
				window.alert("Piosenka został poprawnie zedytowany");
			},
				err => {
					if(err.status == 409){
						window.alert("Podana piosenka istnieje w bazie danych");
					}
					
					else{
						window.alert("Nie udało połączyć się z serwerem");
					}
					
				});
		}
	  
  }
  
  	
	switchValue(clicked: boolean): boolean{
	  return !clicked;
    }

}
