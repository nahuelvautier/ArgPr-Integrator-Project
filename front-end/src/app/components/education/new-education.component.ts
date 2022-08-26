import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Education } from 'src/app/model/education';
import { EducationServiceService } from 'src/app/services/education-service.service';

@Component({
  selector: 'app-new-education',
  templateUrl: './new-education.component.html',
  styleUrls: ['./new-education.component.css']
})
export class NewEducationComponent implements OnInit {
  eduName: string;
  eduCareer: string;
  eduExpedition: string;
  eduDescription: string;
  eduImage: string;

  constructor(private eduService: EducationServiceService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    const edu = new Education(
      this.eduName,
      this.eduCareer,
      this.eduExpedition,
      this.eduDescription,
      this.eduImage
    );

    this.eduService.save(edu).subscribe(data => {
      alert("Educación creada con éxito");
      this.router.navigate(['']);
    }, err => {
      alert("Error al crear la educación");
      this.router.navigate(['']);
    });
  }
}
