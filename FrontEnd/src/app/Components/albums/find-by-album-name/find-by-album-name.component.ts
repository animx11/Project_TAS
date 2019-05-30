import { Component, OnInit } from '@angular/core';
import { Albums } from '../../../Class/albums';
import { AlbumsService } from '../../../Services/albums.service';
import { HttpClient, HttpEvent, HttpResponse, HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-find-by-album-name',
  templateUrl: './find-by-album-name.component.html',
  styleUrls: ['./find-by-album-name.component.css']
})
export class FindByAlbumNameComponent implements OnInit {

	searched: boolean = false;
	searchedAll: boolean = false;
	edit: boolean = false;

	albumName: String;
	albumSearched: Albums = new Albums;
	albumAll: Albums[];

	editAlbumName: String;
	lengthOfAlbum: number;
	albumBand: String;

  constructor(private albumsService: AlbumsService) { }

  ngOnInit() {

	  this.albumName = '';
	  this.albumSearched = new Albums;
	  this.editAlbumName = '';
	  this.lengthOfAlbum = 0;
	  this.albumBand = '';

  }

	findByAlbumName(){

	  this.albumSearched = new Albums();
	  if(this.albumName == ''){
		  window.alert("Nie podano nazwy do wyszukania");
	  }
	  
	  else{
		  
		  this.albumsService.findByAlbumName(this.albumName).subscribe(res => {
				console.log(res);
				
				res.map(el => {
				
						this.albumSearched = new Albums(el);
						this.editAlbumName = this.albumSearched.getAlbumName();
						this.lengthOfAlbum = this.albumSearched.getLengthOfAlbum();
						this.albumBand = this.albumSearched.getBand();

					});
					 
		  });
		  this.albumName = '';
		  this.searched = true;

	  }
	
	}

	findAll(){
		
		this.albumsService.findAll().subscribe(
			res => {
			this.albumAll = res.map(el => new Albums(el));
			console.log(res);
		},
		err => {
			window.alert("Nie udało połączyć się z serwerem");
		}	
	  );
		
	}
	
	deleteAlbum(){
		this.albumsService.deleteAlbum(this.albumSearched.getId()).subscribe(
		res => {
			console.log(res);
			window.alert("Usunięto album z bazy");
		},
		err => {	
				console.log(err);
				window.alert("Wystąpił błąd podczas usuwania albumu, sprawdź czy album istnieje lub połączenie z serwerem");	
			}
		
		);
	  this.albumSearched = new Albums;
	  this.searched = false;
	}
	
	editAlbum(){
		
	  this.albumSearched.setAlbumName(this.editAlbumName);
	  this.albumSearched.setLengthOfAlbum(this.lengthOfAlbum);
	  this.albumSearched.setBand(this.albumBand);
	  	if(this.editAlbumName == '' || this.albumBand == ''){
			window.alert("Dane są niekompletne i/lub nieprawidłowe");
		}
		else{
			this.albumsService.editAlbum(this.albumSearched).subscribe(res => {
				console.log(res);
				window.alert("Album został poprawnie zedytowany");
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
	
	switchValue(clicked: boolean): boolean{
	  return !clicked;
    }

}
