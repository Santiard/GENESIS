package com.omar.genesis.group_semester.model

import com.omar.genesis.semester.model.Semester
import com.omar.genesis.subject_group.model.SubjectGroup

data class GroupSemesterDto(
    var subjectGroup: SubjectGroup,
    var semester: Semester,
)
