import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { AppLogoComponent } from './components/app-logo/app-logo.component';
import { SocialMediaComponent } from './components/social-media/social-media.component';
import { BannerComponent } from './components/banner/banner.component';
import { AboutComponent } from './components/about/about.component';
import { ProfessionalExperienceComponent } from './components/professional-experience/professional-experience.component';
import { EducationComponent } from './components/education/education.component';
import { HardSoftSkillsComponent } from './components/hard-soft-skills/hard-soft-skills.component';

import { NgCircleProgressModule } from 'ng-circle-progress';
import { ProjectsComponent } from './components/projects/projects.component';
import { FooterComponent } from './components/footer/footer.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AppLogoComponent,
    SocialMediaComponent,
    BannerComponent,
    AboutComponent,
    ProfessionalExperienceComponent,
    EducationComponent,
    HardSoftSkillsComponent,
    ProjectsComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    NgCircleProgressModule.forRoot({}),
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
