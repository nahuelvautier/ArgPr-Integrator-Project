export class Education {
  id?: number;
  eduName: string;
  eduCareer: string;
  eduExpedition: string;
  eduDescription: string;
  eduImage: string;

  constructor(
    eduName: string,
    eduCareer: string,
    eduExpedition: string,
    eduDescription: string,
    eduImage: string
  ) {
    this.eduName = eduName;
    this.eduCareer = eduCareer;
    this.eduExpedition = eduExpedition;
    this.eduDescription = eduDescription;
    this.eduImage = eduImage;
  }
}
