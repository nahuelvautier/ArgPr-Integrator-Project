import { Component, OnInit } from '@angular/core';
import { Education } from 'src/app/model/education';
import { EducationServiceService } from 'src/app/services/education-service.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-education',
  templateUrl: './education.component.html',
  styleUrls: ['./education.component.css']
})
export class EducationComponent implements OnInit {
  education: Education[] = [];

  constructor(private eduService: EducationServiceService, private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {
    this.loadEducation();

    if(this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  loadEducation() {
    this.eduService.list().subscribe(data => { this.education = data });
  }

  delete(id?: number) {
    let deleteEdu = confirm("Está seguro que desea eliminar esta educación?");

    if (deleteEdu) {
      if(id !== undefined) {
        this.eduService.delete(id).subscribe(data => this.loadEducation());
      } else {
        alert("No se pudo eliminar la seccion de educación seleccionada.");
      }
    }
  }
}
