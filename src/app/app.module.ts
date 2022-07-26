import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { AppLogoComponent } from './components/app-logo/app-logo.component';
import { SocialMediaComponent } from './components/social-media/social-media.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AppLogoComponent,
    SocialMediaComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
