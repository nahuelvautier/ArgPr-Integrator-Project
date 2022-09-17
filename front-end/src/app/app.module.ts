import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';

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
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { FormsModule } from '@angular/forms';
import { InterceptorProvider } from './services/interceptor-service';
import { EditExperienceComponent } from './components/professional-experience/edit-experience.component';
import { EditEducationComponent } from './components/education/edit-education.component';
import { NewExperienceComponent } from './components/professional-experience/new-experience.component';
import { NewEducationComponent } from './components/education/new-education.component';
import { NewProjectComponent } from './components/projects/new-project.component';
import { EditProjectComponent } from './components/projects/edit-project.component';
import { NewHardSkillComponent } from './components/hard-soft-skills/hard/new-hard-skill/new-hard-skill.component';
import { NewSoftSkillComponent } from './components/hard-soft-skills/soft/new-soft-skill/new-soft-skill.component';
import { EditHardSkillComponent } from './components/hard-soft-skills/hard/edit-hard-skill/edit-hard-skill.component';
import { EditSoftSkillComponent } from './components/hard-soft-skills/soft/edit-soft-skill/edit-soft-skill.component';
import { EditAboutComponent } from './components/about/edit-about.component';
import { EditBannerComponent } from './components/banner/edit-banner.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'experience/create', component: NewExperienceComponent },
  { path: 'experience/update/:id', component: EditExperienceComponent },
  { path: 'education/create', component: NewEducationComponent },
  { path: 'education/update/:id', component: EditEducationComponent },
  { path: 'projects/create', component: NewProjectComponent },
  { path: 'projects/update/:id', component: EditProjectComponent },
  { path: 'hard/skills/create', component: NewHardSkillComponent },
  { path: 'soft/skills/create', component: NewSoftSkillComponent },
  { path: 'hard/skills/update/:id', component: EditHardSkillComponent},
  { path: 'soft/skills/update/:id', component: EditSoftSkillComponent },
  { path: 'persons/update/:id', component: EditAboutComponent },
  { path: 'banner/persons/update/:id', component: EditBannerComponent }
];

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
    FooterComponent,
    HomeComponent,
    LoginComponent,
    EditExperienceComponent,
    EditEducationComponent,
    NewExperienceComponent,
    NewEducationComponent,
    NewProjectComponent,
    EditProjectComponent,
    NewHardSkillComponent,
    NewSoftSkillComponent,
    EditHardSkillComponent,
    EditSoftSkillComponent,
    EditAboutComponent,
    EditBannerComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    NgCircleProgressModule.forRoot({}),
    HttpClientModule,
    FormsModule
  ],
  providers: [
    InterceptorProvider
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
