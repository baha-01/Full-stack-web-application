import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Feedback } from '../models/Feedback';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {
  private apiUrl = "http://localhost:8087/api/feedback"
  constructor(private http: HttpClient) { }

  getAllFeedbacks(): Observable<Feedback[]> {
    return this.http.get<Feedback[]>(this.apiUrl);
  }

  getFeedbackById(id: number): Observable<Feedback> {
    return this.http.get<Feedback>(`${this.apiUrl}/${id}`);
  }

  createFeedback(feedback: Feedback): Observable<Feedback> {
    return this.http.post<Feedback>(this.apiUrl, feedback);
  }

  addFeedbackToProperty(propertyId: number, feedback: Feedback): Observable<Feedback> {
    return this.http.post<Feedback>(`${this.apiUrl}/property/${propertyId}`, feedback);
  }

  updateFeedback(id: number, feedback: Feedback): Observable<Feedback> {
    return this.http.put<Feedback>(`${this.apiUrl}/${id}`, feedback);
  }

  deleteFeedback(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
