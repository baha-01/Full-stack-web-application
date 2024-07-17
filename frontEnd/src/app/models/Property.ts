import { Feedback } from "./Feedback";
export class Property {
    propertyId!:number;
    title!:string;
    description!:string;
    price!:number;
    location!:string;
    type!:PropertyType;
    status!:PropertyStatus;
    postedDate:Date;
    image!:string;
    averageRating!:number;
    feedbacks!: Feedback[];
    constructor(
        propertyId: number,
        title: string,
        description: string,
        price: number,
        location: string,
        type: PropertyType,
        status: PropertyStatus,
        postedDate: Date,
        image: string,
        feedbacks?: Feedback[],
        averageRating?: number
      ) {
        this.propertyId = propertyId;
        this.title = title;
        this.description = description;
        this.price = price;
        this.location = location;
        this.type = type;
        this.status = status;
        this.postedDate = postedDate;
        this.image = image;
        this.feedbacks = feedbacks || [];
        this.averageRating = averageRating || 0;
      }
}


export enum PropertyType {
  Sale = 'Sale',
  Rent = 'Rent'
}

export enum PropertyStatus {
  Available = 'Available',
  Sold = 'Sold'
}