export class Person {
  id?: number;
  personName: string;
  personTitle: string;
  personDescription: string;
  personPicture: string;
  personBanner: string;

  constructor (
      personName: string,
      personTitle: string,
      personDescription: string,
      personPicture: string,
      personBanner: string,
    ) {
    this.personName = personName;
    this.personTitle = personTitle;
    this.personDescription = personDescription;
    this.personPicture = personPicture;
    this.personBanner = personBanner;
  }
}
