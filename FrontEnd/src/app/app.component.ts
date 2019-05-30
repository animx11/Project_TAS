import { Component } from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
  
})
export class AppComponent {
	 
  title = 'FrontendProjectTAS';
  logged: boolean = false;
  isAdminPanelClicked: boolean = false;

  isAddBandClicked: boolean = false;
  isFindBandByNameClicked: boolean = false;

  isAddAlbumClicked: boolean = false;
  isFindAlbumByNameClicked: boolean = false;

  isAddMusicianClicked: boolean = false;
  isFindMusicianByNameClicked: boolean = false;
  
  isAddSongClicked: boolean = false;
  isFindSongByNameClicked: boolean = false;

  
  isUserLogged(isLogged: boolean){
	  this.logged = isLogged;

  }
  
  switchValue(clicked: boolean): boolean{
	  return !clicked;
  }

}
