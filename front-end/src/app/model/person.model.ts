export class Person {
  id?: number;
  name: String;
  lastName: String;
  image: String;

  constructor (name: String, lastName: String, image: String) {
    this.name = name;
    this.lastName = lastName;
    this.image = image;
  }
}
