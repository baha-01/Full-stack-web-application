import { Component, OnInit } from '@angular/core';
import { Property } from '../models/Property';
import { ActivatedRoute, Router } from '@angular/router';
import { PropertyServiceService } from '../services/property-service.service';
import { FeedbackService } from '../services/feedback.service';
import { Feedback } from '../models/Feedback';

@Component({
  selector: 'app-detail-property-admin',
  templateUrl: './detail-property-admin.component.html',
  styleUrls: ['./detail-property-admin.component.css']
})
export class DetailPropertyAdminComponent implements OnInit {
  property!: Property;

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

  updateProperty(): void {
    this.router.navigate(['/update-property', this.property.propertyId]);
  }

  deleteProperty(): void {
    if (confirm('Are you sure you want to delete this property?')) {
      this.propertyService.deleteProperty(this.property.propertyId).subscribe({
        next: () => {
          this.router.navigate(['/admin/property']);
        },
        error: (err) => console.error('Error deleting property: ', err)
      });
    }
  }

  deleteFeedback(feedbackId: number): void {
    if (confirm('Are you sure you want to delete this feedback?')) {
      this.feedbackService.deleteFeedback(feedbackId).subscribe({
        next: () => {
          this.property.feedbacks = this.property.feedbacks.filter(feedback => feedback.feedbackId !== feedbackId);
          this.updateAverageRating();
        },
        error: (err) => console.error('Error deleting feedback: ', err)
      });
    }
  }

  updateAverageRating(): void {
    const totalRating = this.property.feedbacks.reduce((sum, feedback) => sum + feedback.rating, 0);
    const numberOfFeedbacks = this.property.feedbacks.length;
    this.property.averageRating = numberOfFeedbacks ? totalRating / numberOfFeedbacks : 0;
  }
}
