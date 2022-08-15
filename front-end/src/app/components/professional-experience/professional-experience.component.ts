import { Component, OnInit } from '@angular/core';
import { Experience } from 'src/app/model/experience';
import { ExpServiceService } from 'src/app/services/exp-service.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-professional-experience',
  templateUrl: './professional-experience.component.html',
  styleUrls: ['./professional-experience.component.css']
})
export class ProfessionalExperienceComponent implements OnInit {
  experience: Experience[] = [];

  constructor(private expService: ExpServiceService, private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {
    this.loadExperience();

    if(this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  loadExperience(): void {
    this.expService.list().subscribe(data => { this.experience = data} )
  }

  delete(id?: number) {
    if(id !== undefined) {
      this.expService.delete(id).subscribe(data => {
        this.loadExperience();
      });
    } else {
      alert("No se pudo eliminar la experiencia especificada.");
    }
  }
}
