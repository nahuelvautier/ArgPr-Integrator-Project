import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HSS } from 'src/app/model/hss';
import { HssServiceService } from 'src/app/services/hss-service.service';

@Component({
  selector: 'app-new-hard-skill',
  templateUrl: './new-hard-skill.component.html',
  styleUrls: ['./new-hard-skill.component.css']
})
export class NewHardSkillComponent implements OnInit {
  hsPercent: number;
  hsTitle: string;
  hsImage: string;

  constructor(private hssService: HssServiceService, private router: Router) { }

  ngOnInit(): void {
  }

  onCreate(): void {
    const hss = new HSS(this.hsPercent, this.hsTitle, this.hsImage);

    this.hssService.save(hss).subscribe(data => {
      alert("Habilidad añadida con éxito.");
      this.router.navigate(['']);
    }, err => {
      alert(err.error.msg || "Error al añadir la habilidad.");
      this.router.navigate(['']);
    })
  }
}
