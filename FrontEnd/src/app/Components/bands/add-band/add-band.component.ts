import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { HttpClient, HttpEvent, HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Bands } from '../../../Class/bands'
import { BandService } from '../../../Services/band.service'

@Component({
  selector: 'app-add-band',
  templateUrl: './add-band.component.html',
  styleUrls: ['./add-band.component.css']
})
export class AddBandComponent implements OnInit {

	id: number;
	bandName: String;
	yearOfCreation: number;
	origin: String;
	averageRateOfBand: number;
	addNewBand: Bands;
	
	
  constructor(private bandService: BandService) { }

  ngOnInit() {
	  this.bandName = '';
	  this.yearOfCreation = 1900;
	  this.origin = '';
	  this.averageRateOfBand = 0;
	  this.addNewBand = new Bands;
  }
	
	addBand(){
	
		this.addNewBand.setBandName(this.bandName);
		this.addNewBand.setYearOfCreation(this.yearOfCreation);
		this.addNewBand.setOrigin(this.origin);
		this.addNewBand.setAverageRateOfBand(this.averageRateOfBand);
		if(this.bandName == '' || this.yearOfCreation <= 1900 || this.yearOfCreation >= 2019 || this.origin == ''){
			window.alert("Dane są niekompletne i/lub nieprawidłowe");
		}
		else{
			this.bandService.addNewBand(this.addNewBand).subscribe(res => {
				console.log(res);
				window.alert("Dodano nowy zespół");
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

}
