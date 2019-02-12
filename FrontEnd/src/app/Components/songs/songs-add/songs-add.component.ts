import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { HttpClient, HttpEvent, HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Songs } from '../../../Class/songs'
import { SongsService } from '../../../Services/songs.service'

@Component({
  selector: 'app-songs-add',
  templateUrl: './songs-add.component.html',
  styleUrls: ['./songs-add.component.css']
})
export class SongsAddComponent implements OnInit {
	
	songName: String;
	yearOfCreation: number;
	genre: String;
	lengthOfSong: number;
	albumsName: String;
	bandName: String;
	
	addNewSong: Songs;


  constructor(private songsService: SongsService) { }

  ngOnInit() {
	  
	this.songName = '';
	this.yearOfCreation = 0;
	this.genre = '';
	this.lengthOfSong= 0;
	this.albumsName= '';
	this.bandName= '';
	
	this.addNewSong = new Songs();
	
  }


	addSong(){
		
		if(this.songName == '' || this.yearOfCreation <= 1900 || this.yearOfCreation >= 2019 || this.genre == '' || this.albumsName == '' || this.bandName == ''){
			window.alert("Dane są niekompletne i/lub nieprawidłowe");
		}
		else{
			this.addNewSong.setSongName(this.songName);
			this.addNewSong.setYearOfCreation(this.yearOfCreation);
			this.addNewSong.setGenre(this.genre);
			this.addNewSong.setLengthOfSong(this.lengthOfSong);
			this.addNewSong.setAlbums(this.albumsName);
			this.addNewSong.setBand(this.bandName);

			
			this.songsService.addNewSong(this.addNewSong).subscribe(res => {
				console.log(res);
				window.alert("Dodano nową piosenke");
			},
				err => {
					if(err.status == 409){
						window.alert("Podana piosenkam istnieje w bazie danych");
					}
					
					else{
						window.alert("Nie udało połączyć się z serwerem");
					}
					
				});


		}
		
	}
}
