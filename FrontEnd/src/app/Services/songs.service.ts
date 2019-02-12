import { Injectable } from '@angular/core';
import { HttpClient, HttpEvent, HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { ErrorObservable } from 'rxjs/observable/ErrorObservable';
import { Songs } from '../Class/songs';

const apiUrl: String = 'http://localhost:8080/api';

@Injectable()
export class SongsService {

  constructor(private http: HttpClient) { }


	addNewSong(obj:Songs):Observable<any>{
		return this.http.post(`${apiUrl}/songs`, obj);
	}
	
	findBySongName(songName: String): Observable<any>{
		return this.http.get(`${apiUrl}/song_by_songName?songName=${songName}`);

	}
	
	findAll(): Observable<any>{
		return this.http.get(`${apiUrl}/songs`);
	}
	
	deleteSong(id: number){
		return this.http.delete(`${apiUrl}/songs?id=${id}`);
	}
	
	editSong(obj: Songs): Observable<any>{
		return this.http.put(`${apiUrl}/songs`, obj);
	}

}
