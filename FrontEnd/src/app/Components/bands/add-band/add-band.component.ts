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
		this.bandService.addNewBand(this.addNewBand).subscribe(res => console.log(res));
		
	
	}

}
