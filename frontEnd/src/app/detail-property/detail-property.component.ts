import { Component, OnInit } from '@angular/core';
import { Property } from '../models/Property';
import { ActivatedRoute, Router } from '@angular/router';
import { PropertyServiceService } from '../services/property-service.service';
import { FeedbackService } from '../services/feedback.service';
import { Feedback } from '../models/Feedback';

@Component({
  selector: 'app-detail-property',
  templateUrl: './detail-property.component.html',
  styleUrl: './detail-property.component.css'
})
export class DetailPropertyComponent implements OnInit {
  property!: Property;
  newFeedback: Feedback = { feedbackId: 0, rating: 0, content: '', datePosted: new Date(), propertyId: 0 };

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private propertyService: PropertyServiceService,
    private feedbackService: FeedbackService
  ) {}

  ngOnInit(): void {
    const propertyId = this.route.snapshot.paramMap.get('id');
    if (propertyId) {
      this.propertyService.getPropertyById(+propertyId).subscribe({
        next: (data) => this.property = data,
        error: (err) => console.error('Error fetching property: ', err)
      });
    }
  }

  getStarsArray(rating: number): string[] {
    const fullStars = Math.floor(rating);
    const halfStar = rating % 1 !== 0;
    const emptyStars = 5 - fullStars - (halfStar ? 1 : 0);

    const starsArray: string[] = [];
    for (let i = 0; i < fullStars; i++) {
      starsArray.push('fas fa-star text-warning');
    }
    if (halfStar) {
      starsArray.push('fas fa-star-half-alt text-warning');
    }
    for (let i = 0; i < emptyStars; i++) {
      starsArray.push('far fa-star text-warning');
    }

    return starsArray;
  }
  addFeedback(): void {
    const propertyId = this.route.snapshot.paramMap.get('id');
    if (propertyId) {
      this.newFeedback.propertyId = +propertyId;
      this.feedbackService.addFeedbackToProperty(+propertyId, this.newFeedback).subscribe({
        next: (feedback) => {
          this.property.feedbacks.push(feedback);
          this.updateAverageRating();
          this.newFeedback = { feedbackId: 0, rating: 0, content: '', datePosted: new Date(), propertyId: 0 };
          this.router.navigate([`/property/${propertyId}`]);
        },
        error: (err) => console.error('Error adding feedback: ', err)
      });
    }
  }
  updateAverageRating(): void {
    const totalRating = this.property.feedbacks.reduce((sum, feedback) => sum + feedback.rating, 0);
    const numberOfFeedbacks = this.property.feedbacks.length;
    this.property.averageRating = numberOfFeedbacks ? totalRating / numberOfFeedbacks : 0;
  }
}
