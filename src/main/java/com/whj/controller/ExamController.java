package com.whj.controller;

import com.whj.pojo.Course;
import com.whj.pojo.Exam;
import com.whj.pojo.Paper;
import com.whj.pojo.StudentExam;
import com.whj.service.CourseService;
import com.whj.service.ExamService;
import com.whj.service.PaperService;
import com.whj.service.StudentExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

@Controller
public class ExamController {
    @Autowired
    ExamService examService;
    @Autowired
    CourseService courseService;
    @Autowired
    PaperService paperService;
    @Autowired
    StudentExamService studentExamService;

    // 获取考试信息列表
    @GetMapping("/examList")
    public String examList(HttpServletRequest request, Model model){
        Integer classid = (Integer) request.getSession().getAttribute("classid");
        List<Exam> examClassid = examService.getExamClassid(classid);
        for (Exam exam : examClassid) {
            Course allById = courseService.getAllById(exam.getCno());
            exam.setCourse(allById);
        }
        model.addAttribute("examslenth",examClassid.size());
        model.addAttribute("exams",examClassid);
        return "student/examList";
    }

    // 查询考试信息
    @ResponseBody
    @PostMapping("/findExamByEid")
    public Exam findExamById(@RequestBody Exam exam){
        Exam examName = examService.getExamName(exam.getEid());
        if(examName!=null){
            return examName;
        }else{
            return null;
        }
    }

    // 查询试卷
    @GetMapping("/paper")
    public String findPaper(Integer eid,HttpServletRequest request,Model model){
        List<Paper> byEid = paperService.getByEid(eid);
        int size = byEid.size();
        Exam examName = examService.getExamName(eid);
        request.getSession().setAttribute("single",byEid);
        model.addAttribute("cont",size);
        model.addAttribute("exam",examName);

        return "student/papers";
    }

    // 显示考试成绩
    @PostMapping("/PaperScore")
    public String paperScore(HttpServletRequest request,Model model){
        // 数组存放答案
        String stuArr[]=null;

        // 初始成绩
        Integer score=0;

        // 获取每道题的分数
        Integer eid = Integer.valueOf(request.getParameter("eid"));
        Exam examName = examService.getExamName(eid);
        Integer singlecore = examName.getSinglecore();

        // 获取试卷问题的列表
        List<Paper> single = (List<Paper>) request.getSession().getAttribute("single");

        // 获取试卷id
        for(int i=0; i<single.size(); i++){
            Paper paper = single.get(i);
            stuArr = request.getParameterValues(String.valueOf(paper.getSid()));
            if(stuArr!=null){
                String stuKeys = "";
                // 封装答案
                for (int j = 0; j < stuArr.length; j++) {
                    stuKeys += stuArr[j];
                }
                if(stuKeys.equalsIgnoreCase(paper.getSkey())){
                    score += singlecore;
                }else{

                }
            }else{
                return "redirect:/examList";
            }
        }

        // 计算总成绩
        int zscore = single.size() * singlecore;
        // 学生成绩
        model.addAttribute("score",score);
        String pname = request.getParameter("pname");
        String tjtime = request.getParameter("tjtime");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        timestamp.valueOf(tjtime);
        Integer classid = (Integer) request.getSession().getAttribute("classid");
        Integer userid = (Integer) request.getSession().getAttribute("lis");

        StudentExam studentExam = new StudentExam();
        studentExam.setEid(eid);
        studentExam.setScore(score);
        studentExam.setPname(pname);
        studentExam.setClassid(classid);
        studentExam.setUserid(userid);
        studentExam.setTitime(tjtime);
        studentExam.setZscore(zscore);
        studentExamService.addStudentExam(studentExam);


        return "student/paperScore";
    }

    // 查询学生考试历史
    @GetMapping("/findAllStuPaper")
    public String findStuPaperList(HttpServletRequest request,Model model){
        Integer userid = (Integer) request.getSession().getAttribute("lis");
        List<StudentExam> studentExams = studentExamService.getstuExamLlist(userid);
        model.addAttribute("stuexamlist",studentExams);
        return "student/stuPaperList";
    }

    // 查询是否做过该试卷
    @ResponseBody
    @PostMapping("/findOneStuExam")
    public List<StudentExam> findIsPaper(HttpServletRequest request,@RequestBody Exam exam){
        // 学生id
        Integer userid = (Integer) request.getSession().getAttribute("lis");
        Integer eid = exam.getEid();
        List<StudentExam> isPaper = studentExamService.getIsPaper(userid, eid);
        return isPaper;
    }

    // 返回在线考试系统
    @GetMapping("/StuMan")
    public String getStuMan(){
        return "student/StuMan";
    }


}
