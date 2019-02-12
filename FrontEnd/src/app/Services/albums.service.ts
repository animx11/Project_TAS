import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { ErrorObservable } from 'rxjs/observable/ErrorObservable';
import { Albums } from '../Class/albums';

import 'rxjs/add/operator/catch';

const apiUrl: String = 'http://localhost:8080/api';

@Injectable()
export class AlbumsService {

  constructor(private http: HttpClient) { }


	addNewAlbum(obj:Albums):Observable<any>{
		return this.http.post(`${apiUrl}/albums`, obj);
	}
	
	findByAlbumName(albumName: String): Observable<any>{
		return this.http.get(`${apiUrl}/albums_by_albumName?albumName=${albumName}`);

	}
	
	findAll(): Observable<any>{
		return this.http.get(`${apiUrl}/albums`);
	}
	
	deleteAlbum(id: number){
		return this.http.delete(`${apiUrl}/albums?id=${id}`);
	}
	
	editAlbum(obj: Albums): Observable<any>{
		return this.http.put(`${apiUrl}/albums`, obj);
	}

}
