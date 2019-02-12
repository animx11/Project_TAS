import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { ErrorObservable } from 'rxjs/observable/ErrorObservable';
import { Musicians } from '../Class/musicians';

const apiUrl: String = 'http://localhost:8080/api';

@Injectable()
export class MusiciansService {

  constructor(private http: HttpClient) { }


	addNewMusicians(obj:Musicians):Observable<any>{
		return this.http.post(`${apiUrl}/musician`, obj);
	}

	
	findAll(): Observable<any>{
		return this.http.get(`${apiUrl}/musician`);
	}
	
	deleteMusicians(id: number){
		return this.http.delete(`${apiUrl}/musician?id=${id}`);
	}
	
	editMusicians(obj: Musicians): Observable<any>{
		return this.http.put(`${apiUrl}/musician`, obj);
	}


}
