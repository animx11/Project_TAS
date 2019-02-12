import { Bands } from './bands'

export class Musicians{

	private id: number;
	private firstName: String;
	private lastName: String;
	private pseudonym: String;
	private band: String;
	private birthDate: Date;
	private origin: String;
	private instrument: String;
	private averageRateOfAlbum: number;

	constructor(obj?: any){
	
		this.id = (obj && obj.id) || 0;
		this.firstName = (obj && obj.firstName) || '';
		this.lastName = (obj && obj.lastName) || '';
		this.pseudonym = (obj && obj.pseudonym) || '';
		this.band = (obj && obj.band) || '';
		this.birthDate = (obj && obj.birthDate) || new Date;
		this.origin = (obj && obj.origin) || '';
		this.instrument = (obj && obj.instrument) || '';
		this.averageRateOfAlbum = (obj && obj.averageRateOfAlbum) || 0;

	}

	getId(): number{
		return this.id;
	}
	setId(id: number){
		this.id = id;
	}
	
	getFirstName(): String{
		return this.firstName;
	}
	setFirstName(firstName: String){
		this.firstName = firstName;
	}

	getLastName(): String{
		return this.lastName;
	}
	setLastName(lastName: String){
		this.lastName = lastName;
	}

	getPseudonym(): String{
		return this.pseudonym;
	}
	setPseudonym(pseudonym: String){
		this.pseudonym = pseudonym;
	}
	
	getBand(): String{
		return this.band;
	}
	setBand(band: String){
		this.band = band;
	}
	
	getBirthDate(): Date{
		return this.birthDate;
	}
	setBirthDate(birthDate: Date){
		this.birthDate = birthDate;
	}

	getOrigin(): String{
		return this.origin;
	}
	setOrigin(origin: String){
		this.origin = origin;
	}

	getInstrument(): String{
		return this.instrument;
	}
	setInstrument(instrument: String){
		this.instrument = instrument;
	}

	getAverageRateOfAlbum(): number{
		return this.averageRateOfAlbum;
	}
	setAverageRateOfAlbum(averageRateOfAlbum: number){
		this.averageRateOfAlbum = averageRateOfAlbum;
	}



}