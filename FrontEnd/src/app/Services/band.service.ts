import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { ErrorObservable } from 'rxjs/observable/ErrorObservable';
import { Bands } from '../Class/bands'

import 'rxjs/add/operator/catch';


const apiUrl: String = 'http://localhost:3000/api';

@Injectable()
export class BandService {

  constructor(private http: HttpClient) { }
	
	addNewBand(obj:Bands):Observable<any>{
		return this.http.post(`${apiUrl}/bands`, obj);
	}

}
