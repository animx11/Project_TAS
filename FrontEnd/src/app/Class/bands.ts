export class Bands{

	private id: number;
	private bandName: String;
	private yearOfCreation: number;
	private origin: String;
	private averageRateOfBand: number;
	
	constructor(obj?: any){
		
		this.id = (obj && obj.id) || 0;
		this.bandName = (obj && obj.bandName) || '';
		this.yearOfCreation = (obj && obj.yearOfCreation) || 0;
		this.origin = (obj && obj.origin) || '';
		this.averageRateOfBand = (obj && obj.averageRateOfBand) || 0;
	
	}
	
	getId(): number{
		return this.id;
	}
	setId(id: number){
		this.id = id;
	}
	
	getBandName(): String{
		return this.bandName;
	}
	setBandName(bandName: String){
		this.bandName = bandName;
	}
	
	getYearOfCreation(): number{
		return this.yearOfCreation;
	}
	setYearOfCreation(yearOfCreation: number){
		this.yearOfCreation = yearOfCreation;
	}
	
	getOrigin(): String{
		return this.origin;
	}
	setOrigin(origin: String){
		this.origin = origin;
	}
	
	getAverageRateOfBand(){
		return this.averageRateOfBand;
	}
	setAverageRateOfBand(averageRateOfBand: number){
		this.averageRateOfBand = averageRateOfBand;
		
	}

}