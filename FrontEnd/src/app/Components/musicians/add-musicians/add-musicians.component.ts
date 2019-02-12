import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { HttpClient, HttpEvent, HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Musicians } from '../../../Class/musicians';
import { Bands } from '../../../Class/bands';
import { MusiciansService } from '../../../Services/musicians.service';
import { BandService } from '../../../Services/band.service';

@Component({
  selector: 'app-add-musicians',
  templateUrl: './add-musicians.component.html',
  styleUrls: ['./add-musicians.component.css']
})
export class AddMusiciansComponent implements OnInit {

	firstName: String;
	lastName: String;
	pseudonym: String;
	bandName: String;
	birthday: Date;
	origin: String;
	instrument: String;

	addNewMusician: Musicians;
	musicianBand: Bands;


  constructor(private musiciansService: MusiciansService, private bandService: BandService) { }

  ngOnInit() {

	  this.firstName = '';
	  this.lastName = '';
	  this.pseudonym = '';
	  this.bandName = '';
	  this.birthday = new Date();
	  this.origin = '';
	  this.instrument = '';
	  this.addNewMusician = new Musicians;
	  this.musicianBand = new Bands;

  }


	addMusician(){
	
		this.addNewMusician.setFirstName(this.firstName);
		this.addNewMusician.setLastName(this.lastName);
		this.addNewMusician.setPseudonym(this.pseudonym);
		this.addNewMusician.setOrigin(this.origin);
		this.addNewMusician.setInstrument(this.instrument);
		this.addNewMusician.setBirthDate(this.birthday);
		/*
		this.bandService.findByBandName(this.bandName).subscribe(
			res => {
				res.map(el => this.musicianBand = new Bands(el));
				console.log(res);
			}
		);
		*/
		//this.addNewMusician.setBand(this.musicianBand);
		if(this.firstName == '' || this.lastName == ''|| this.pseudonym == ''|| this.bandName == ''|| this.origin == ''|| this.instrument == ''){
			window.alert("Dane są niekompletne i/lub nieprawidłowe");
		}
		//window.alert(this.addNewMusician.getBand().getBandName());
		
		this.addNewMusician.setBirthDate(null);
		this.addNewMusician.setBand(null);
		this.musiciansService.addNewMusicians(this.addNewMusician).subscribe();

/*
		else{
			this.musiciansService.addNewMusicians(this.addNewMusician).subscribe(res => {
				console.log(res);
				window.alert("Dodano artyste");
			},
				err => {
					if(err.status == 409){
						window.alert("Podany artysta istnieje w bazie danych");
					}
					
					else{
						console.log(res);
						window.alert("Nie udało połączyć się z serwerem");
					}
					
				});
		}
		*/
	
	}

}
