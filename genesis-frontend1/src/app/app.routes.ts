import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { PdgdocumentsComponent } from './pages/pdgdocuments/pdgdocuments.component';
import { PaymentReceiptsComponent } from './pages/payment-receipts/payment-receipts.component';
import { StdscoresComponent } from './pages/stdscores/stdscores.component';
import { PolygraphComponent } from './pages/polygraph/polygraph.component';
import { CurriculumComponent } from './pages/curriculum/curriculum.component';
import { ScheduleComponent } from './pages/schedule/schedule.component';
import { EnrollmentsComponent } from './pages/enrollments/enrollments.component';

export const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'pdgdocuments', component: PdgdocumentsComponent },
  { path: 'curriculum', component: CurriculumComponent },
  { path: 'stdscores', component: StdscoresComponent },
  { path: 'polygraph', component: PolygraphComponent },
  { path: 'payment_receipts', component: PaymentReceiptsComponent },
  { path: 'schedule', component: ScheduleComponent },
  { path: 'enrollments', component: EnrollmentsComponent },
  { path: '**', redirectTo: '' },
];
