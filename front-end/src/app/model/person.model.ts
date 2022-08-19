export class Person {
  id?: number;
  name: string;
  lastName: string;
  image: string;

  constructor (name: string, lastName: string, image: string) {
    this.name = name;
    this.lastName = lastName;
    this.image = image;
  }
}
