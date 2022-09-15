export class HSS {
  id?: number;
  hsPercent: number;
  hsTitle: string;
  hsImage: string;

  constructor(hsPercent: number, hsTitle: string, hsImage: string) {
    this.hsPercent = hsPercent;
    this.hsTitle = hsTitle;
    this.hsImage = hsImage;
  }
}
