export class Project {
  id?: number;
  proName: string;
  proDescription: string;
  proApiUsed: string;
  proExpedition: string;
  proHref: string;

  constructor(
    proName: string,
    proDescription: string,
    proApiUsed: string,
    proExpedition: string,
    proHref: string
  ) {
    this.proName = proName;
    this.proDescription = proDescription;
    this.proApiUsed = proApiUsed;
    this.proExpedition = proExpedition;
    this.proHref = proHref;
  }
}
