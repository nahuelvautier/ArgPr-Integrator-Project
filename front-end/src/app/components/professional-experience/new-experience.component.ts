import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Experience } from 'src/app/model/experience';
import { ExpServiceService } from 'src/app/services/exp-service.service';

@Component({
  selector: 'app-new-experience',
  templateUrl: './new-experience.component.html',
  styleUrls: ['./new-experience.component.css']
})
export class NewExperienceComponent implements OnInit {
  expName: string;
  expDescription: string;
  expReference: string;
  expImage: string;
  expSupplier: string;

  constructor(private expService: ExpServiceService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    const exp = new Experience(
      this.expName,
      this.expDescription,
      this.expReference,
      this.expImage,
      this.expSupplier
    );

    this.expService.save(exp).subscribe(data =>{
      alert("Experiencia creada con éxito");
      this.router.navigate(['']);
    }, err => {
      alert(err.error.msg || "Error al añadir la experiencia.");
      this.router.navigate(['']);
    });
  }

}
