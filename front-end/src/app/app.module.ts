import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { AppLogoComponent } from './components/app-logo/app-logo.component';
import { SocialMediaComponent } from './components/social-media/social-media.component';
import { BannerComponent } from './components/banner/banner.component';
import { AboutComponent } from './components/about/about.component';
import { ProfilePhotoComponent } from './components/profile-photo/profile-photo.component';
import { AboutDescriptionComponent } from './components/about-description/about-description.component';
import { ProfessionalExperienceComponent } from './components/professional-experience/professional-experience.component';
import { EducationComponent } from './components/education/education.component';
import { HardSoftSkillsComponent } from './components/hard-soft-skills/hard-soft-skills.component';

import { NgCircleProgressModule } from 'ng-circle-progress';
import { ProjectsComponent } from './components/projects/projects.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AppLogoComponent,
    SocialMediaComponent,
    BannerComponent,
    AboutComponent,
    ProfilePhotoComponent,
    AboutDescriptionComponent,
    ProfessionalExperienceComponent,
    EducationComponent,
    HardSoftSkillsComponent,
    ProjectsComponent
  ],
  imports: [
    BrowserModule,
    NgCircleProgressModule.forRoot({})
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
