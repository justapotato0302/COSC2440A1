package StudentEnrolment;

import java.util.List;

public interface StudentEnrolmentManager {
    public List<Enrolment> add(List<Enrolment> eList,Enrolment enrolment);
    public void Update(List<Enrolment> eList,Enrolment enrolment,int index);
    public List<Enrolment> Delete(List<Enrolment> eList,int index);

}
