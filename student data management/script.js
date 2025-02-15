document.addEventListener('DOMContentLoaded', () => {
  const form = document.getElementById('studentForm');
  const studentTable = document.getElementById('studentTable').querySelector('tbody');
  const rollNumberInput = document.getElementById('rollNumber');
  const tableContainer = document.querySelector('.table-container');

  function checkScroll() {
    if (studentTable.scrollHeight > tableContainer.clientHeight) {
      tableContainer.style.overflowY = 'auto'; 
    } else {
      tableContainer.style.overflowY = 'hidden'; 
    }
  }

  form.addEventListener('submit', (event) => {
    event.preventDefault();

    const rollNumber = rollNumberInput.value.trim();
    const name = document.getElementById('name').value.trim();
    const gender = document.getElementById('gender').value;
    const standard = document.getElementById('standard').value;
    const dob = document.getElementById('dob').value;
    const newRow = document.createElement('tr');
    newRow.innerHTML = `
      <td>${rollNumber}</td>
      <td>${name}</td>
      <td>${gender}</td>
      <td>${standard}</td>
      <td>${dob}</td>
      <td>
        <button class="edit-btn">Edit</button>
        <button class="delete-btn">Delete</button>
      </td>
    `;
    studentTable.appendChild(newRow);
    form.reset();
    checkScroll(); 
  });

  studentTable.addEventListener('click', (event) => {
    const target = event.target;

    if (target.classList.contains('delete-btn')) {
      if (confirm("Are you sure you want to delete this record?")) {
        target.closest('tr').remove();
        checkScroll(); 
      }
    } else if (target.classList.contains('edit-btn')) {
      const row = target.closest('tr');
      const rollNumber = row.children[0].textContent;
      const name = row.children[1].textContent;
      const gender = row.children[2].textContent;
      const standard = row.children[3].textContent;
      const dob = row.children[4].textContent;
      rollNumberInput.value = rollNumber;
      document.getElementById('name').value = name;
      document.getElementById('gender').value = gender;
      document.getElementById('standard').value = standard;
      document.getElementById('dob').value = dob;
      row.remove();
      checkScroll(); 
    }
  });
});
