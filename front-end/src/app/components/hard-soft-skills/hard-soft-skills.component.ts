import { Component, OnInit } from '@angular/core';
import { HSS } from 'src/app/model/hss';
import { HssServiceService } from 'src/app/services/hss-service.service';
import { TokenService } from 'src/app/services/token.service';

@Component({
  selector: 'app-hard-soft-skills',
  templateUrl: './hard-soft-skills.component.html',
  styleUrls: ['./hard-soft-skills.component.css']
})
export class HardSoftSkillsComponent implements OnInit {
  hss: HSS[] = [];

  constructor(private hssService: HssServiceService, private tokenService: TokenService) { }

  isLogged = false;

  ngOnInit(): void {
    this.loadSkills();

    if(this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  loadSkills() {
    this.hssService.list().subscribe(data => { this.hss = data });
  }

  delete(id?: number) {
    let deleteSkill = confirm("Está seguro que desea eliminar esta habilidad?");

    if (deleteSkill) {
      this.hssService.delete(id).subscribe(data => this.loadSkills());
    } else {
      alert("No se pudo eliminar la habilidad seleccionada.");
    }
  }
}
