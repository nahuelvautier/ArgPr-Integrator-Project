import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewSoftSkillComponent } from './new-soft-skill.component';

describe('NewSoftSkillComponent', () => {
  let component: NewSoftSkillComponent;
  let fixture: ComponentFixture<NewSoftSkillComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewSoftSkillComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewSoftSkillComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
