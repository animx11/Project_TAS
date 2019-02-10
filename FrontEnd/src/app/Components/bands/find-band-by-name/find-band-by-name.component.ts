import { Component, OnInit } from '@angular/core';
import { Bands } from '../../../Class/bands'
import { BandService } from '../../../Services/band.service'
import { HttpClient, HttpEvent, HttpResponse, HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-find-band-by-name',
  templateUrl: './find-band-by-name.component.html',
  styleUrls: ['./find-band-by-name.component.css']
})
export class FindBandByNameComponent implements OnInit {

	bandName: String;
	bandSearched: Bands = new Bands;
	bandAll: Bands[];
	searched: boolean = false;
	searchedAll: boolean = false;
	edit: boolean = false;
	
	editBandName: String;
	yearOfCreation: number;
	origin: String;

  constructor(private bandService: BandService) { }

  ngOnInit() {
	  this.bandName = '';
	  this.bandSearched = new Bands;
	  
	  this.editBandName = '';
	  this.yearOfCreation = 1900;
	  this.origin = '';
	  
  }
  
  findByBandName(){
	  this.bandSearched = new Bands;
	  if(this.bandName == ''){
		  window.alert("Nie podano nazwy do wyszukania");
	  }
	  else{
		  this.bandService.findByBandName(this.bandName).subscribe(res => {
				console.log(res);
				res.map(el => {
				
						this.bandSearched = new Bands(el);
						this.editBandName = this.bandSearched.getBandName();
						this.yearOfCreation = this.bandSearched.getYearOfCreation();
						this.origin = this.bandSearched.getOrigin();
					});
		  });

		  
		  this.bandName = '';
		  this.searched = true;

	  }
	  
	 
	  
  }
  
  findAll(){
	  this.bandService.findAll().subscribe(
		res => {
			this.bandAll = res.map(el => new Bands(el));
			console.log(res);
		},
		err => {
			window.alert("Nie udało połączyć się z serwerem");
		}	
	  );
  }
  
  editBand(){

	  this.bandSearched.setBandName(this.editBandName);
	  this.bandSearched.setYearOfCreation(this.yearOfCreation);
	  this.bandSearched.setOrigin(this.origin);
	  	if(this.editBandName == '' || this.yearOfCreation <= 1900 || this.yearOfCreation >= 2019 || this.origin == ''){
			window.alert("Dane są niekompletne i/lub nieprawidłowe");
		}
		else{
			this.bandService.editBand(this.bandSearched).subscribe(res => {
				console.log(res);
				window.alert("Zespół został poprawnie zedytowany");
			},
				err => {
					if(err.status == 409){
						window.alert("Podany zespół istnieje w bazie danych");
					}
					
					else{
						window.alert("Nie udało połączyć się z serwerem");
					}
					
				});
		}
  }
  
  deleteBand(){

	  this.bandService.deleteBand(this.bandSearched.getId()).subscribe(
		res => {
			console.log(res);
			window.alert("Usunięto zespół z bazy");
		},
		err => {	
				console.log(err);
				window.alert("Wystąpił błąd podczas usuwania zespołu, sprawdź czy zespół istnieje lub połączenie z serwerem");	
			}
		
		);
	  this.bandSearched = new Bands;
	  this.searched = false;
	  
  }
  
  switchValue(clicked: boolean): boolean{
	  return !clicked;
  }

}
