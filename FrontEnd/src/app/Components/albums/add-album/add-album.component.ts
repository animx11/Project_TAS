import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { HttpClient, HttpEvent, HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Albums } from '../../../Class/albums'
import { AlbumsService } from '../../../Services/albums.service'

@Component({
  selector: 'app-add-album',
  templateUrl: './add-album.component.html',
  styleUrls: ['./add-album.component.css']
})
export class AddAlbumComponent implements OnInit {

	albumName: String;
	lengthOfAlbum: number;
	band: String;
	addNewAlbum: Albums;

  constructor(private albumsService: AlbumsService) { }

  ngOnInit() {

	this.albumName = '';
	this.lengthOfAlbum = 0;
	this.band = '';
	this.addNewAlbum = new Albums;

  }

	addAlbum(){
		

		if(this.albumName == '' || this.band == ''){
			window.alert("Dane są niekompletne i/lub nieprawidłowe");
		}
		else{
			this.addNewAlbum.setAlbumName(this.albumName);
			this.addNewAlbum.setLengthOfAlbum(this.lengthOfAlbum);
			this.addNewAlbum.setBand(this.band);
			
			this.albumsService.addNewAlbum(this.addNewAlbum).subscribe(res => {
				console.log(res);
				window.alert("Dodano nowy album");
			},
				err => {
					if(err.status == 409){
						window.alert("Podany album istnieje w bazie danych");
					}
					
					else{
						window.alert("Nie udało połączyć się z serwerem");
					}
					
				});


		}

	}	
}
