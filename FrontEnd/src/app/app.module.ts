import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router'
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { Observable } from 'rxjs/Observable';

import { AppComponent } from './app.component';
import { LoginComponent } from './Components/login/login.component';
import { LoginService } from './Services/login.service';
import { BandService } from './Services/band.service';
import { AlbumsService } from './Services/albums.service';
import { SongsService } from './Services/songs.service';
import { MusiciansService } from './Services/musicians.service';
import { RejestracjaComponent } from './Components/rejestracja/rejestracja.component';
import { AddBandComponent } from './Components/bands/add-band/add-band.component';
import { FindBandByNameComponent } from './Components/bands/find-band-by-name/find-band-by-name.component';
import { DeleteBandComponent } from './Components/bands/delete-band/delete-band.component';
import { AlbumHandlerComponent } from './Components/albums/album-handler/album-handler.component';
import { AddAlbumComponent } from './Components/albums/add-album/add-album.component';
import { FindByAlbumNameComponent } from './Components/albums/find-by-album-name/find-by-album-name.component';
import { AddMusiciansComponent } from './Components/musicians/add-musicians/add-musicians.component';
import { SongsAddComponent } from './Components/songs/songs-add/songs-add.component';
import { FindBySongNameComponent } from './Components/songs/find-by-song-name/find-by-song-name.component'

const ROUTES: Routes = [
	{path: 'login', component: LoginComponent},
	{path: 'rejestracja', component: RejestracjaComponent}
];
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RejestracjaComponent,
    AddBandComponent,
    FindBandByNameComponent,
    DeleteBandComponent,
    AlbumHandlerComponent,
    AddAlbumComponent,
    FindByAlbumNameComponent,
    AddMusiciansComponent,
    SongsAddComponent,
    FindBySongNameComponent
  ],
  imports: [
    BrowserModule,
	FormsModule,
	HttpClientModule,
	RouterModule.forRoot(ROUTES)
  ],
  providers: [LoginService, BandService, AlbumsService, SongsService, MusiciansService],
  bootstrap: [AppComponent]
})
export class AppModule { }
