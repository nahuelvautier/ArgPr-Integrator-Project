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
  expName: string = '';
  expDescription: string = '';
  expReference: string = '';
  expImage: string = '';
  expSupplier: string = '';

  constructor(private expService: ExpServiceService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    const newExp = new Experience(
      this.expName,
      this.expDescription,
      this.expReference,
      this.expImage,
      this.expSupplier,
      );

    this.expService.save(newExp).subscribe(data => {
      alert('Experiencia agregada exitosamente');
      this.router.navigate(['']);
    }, err => {
      alert('Hubo un error, no pudo crearse la experiencia especificada anteriormente.');
      this.router.navigate(['']);
    });
  }

}
