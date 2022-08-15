export class Experience {
  id?: number;
  expName: string;
  expDescription: string;
  expReference: string;
  expImage: string;
  expSupplier: string;

  constructor(
    expName: string,
    expDescription: string,
    expReference: string,
    expImage: string,
    expSuppler: string
    ) {
      this.expName = expName;
      this.expDescription = expDescription;
      this.expReference = expReference;
      this.expImage = expImage;
      this.expSupplier = expSuppler;
  }
}
